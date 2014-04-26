import me.ianibbo.common.*;

class AuthModelBootStrap {

    def init = { servletContext ->
      log.debug("Init AuthModelBootStrap");
      RefdataCategory.lookupOrCreate('YN', 'Yes').save()
      RefdataCategory.lookupOrCreate('YN', 'No').save()
    }

    def destroy = {
    }
}

