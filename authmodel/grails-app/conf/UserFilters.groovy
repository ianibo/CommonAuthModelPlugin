import me.ianibbo.common.*


class UserFilters {
   
  def springSecurityService

  def filters = {
    setPrefsFilter(controller:'*', action:'*') {
      before = {

        if ( springSecurityService.principal instanceof String ) {
          log.debug("User is string: ${springSecurityService.principal}");
        }
        else if (springSecurityService.principal?.username != null ) {
          log.debug("Set request.user to ${springSecurityService.principal}");
          request.user = AuthCommonUser.findByUsername(springSecurityService.principal.username);
          
          // Just set the user preferences equal to those of the current user.
          // if ( session.userPereferences == null ) {
          //   session.userPereferences = request.user.getUserPreferences()
          // }
        }

        // if ( session.sessionPreferences == null ) {
        //   session.sessionPreferences = grailsApplication.config.appDefaultPrefs
        // }
        // else {
        // }

      }
    }
  }
}
