import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import au.com.bytecode.opencsv.CSVReader
import me.ianibbo.common.*;


class AuthModelAdminController {

  def index() {
  }

  @Secured(['ROLE_ADMIN', 'IS_AUTHENTICATED_FULLY'])
  def loadOrgs() {
    log.debug("AuthModelAdminController::loadOrgs()");

    try {
      // if ( request.method=='POST') {
      if ( params.orgs_file != null ) {
        log.debug("Post....");
        def upload_mime_type = request.getFile("orgs_file")?.contentType
        def upload_filename = request.getFile("orgs_file")?.getOriginalFilename()
        def input_stream = request.getFile("orgs_file")?.inputStream

        CSVReader r = new CSVReader( new InputStreamReader(input_stream, java.nio.charset.Charset.forName('UTF-8') ) )
        def current_org = RefdataCategory.lookupOrCreate('OrgStatus','Current',null);

        String[] nl;
        def first = true
        while ((nl = r.readNext()) != null) {
          if ( first ) {
            first = false; // Skip header
            // Expected cols
            // [0]Name,[1]Short name,[2]URL name,[3]Tags,[4]Home page,Publication scheme,Disclosure log,Notes,Created at,Updated at,Version

          }
          else {
            def shortcode = nl[1]
            AuthCommonOrganisation aco = AuthCommonOrganisation.findByShortcode(shortcode)
            if ( aco == null ) {
              aco = new AuthCommonOrganisation(status:current_org, shortcode:shortcode, url:nl[4], displayName:nl[0]).save();
            }
          }
        }

      }
    }
    catch ( Exception e ) {
      log.error("Problem",e);
    }

    redirect(url: request.getHeader('referer'))
  }
}
