import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured


class AuthModelAdminController {

  def index() {
  }

  @Secured(['ROLE_ADMIN', 'IS_AUTHENTICATED_FULLY'])
  def loadOrgs() {
    log.debug("AuthModelAdminController::loadOrgs()");

    try {
      if ( request.method=='POST') {
        log.debug("Post....");
        def file = request.getFile("orgsfile")
        // def record = new String(file.getBytes())
      }
    }
    catch ( Exception e ) {
      log.error("Problem",e);
    }

    redirect(url: request.getHeader('referer'))
  }
}
