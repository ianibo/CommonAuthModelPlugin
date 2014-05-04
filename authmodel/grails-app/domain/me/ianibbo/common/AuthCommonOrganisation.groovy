package me.ianibbo.common

class AuthCommonOrganisation extends AuthCommonParty {

  RefdataValue status
  String shortcode
  String url
  String pubScheme
  String email
  String twitter
  String facebook

  static constraints = {
    status(nullable:false, blank:false)
    shortcode(nullable:false, blank:false, unique:true)
    url(nullable:true, blank:false)
    pubScheme(nullable:true, blank:true)
    email(nullable:true, blank:true)
    twitter(nullable:true, blank:true)
    facebook(nullable:true, blank:true)
  }

  static mapping = {
    pubScheme type:'text'
    shortcode index:'ap_shortcode'
  }

  static def refdataFind(params) {
    def result = [];
    def ql = null;

    def query = "from AuthCommonOrganisation as o where lower(o.displayName) like ?"
    def query_params = ["%${params.q.toLowerCase()}%"]

    if ( ( params.filter1 != null ) && ( params.filter1.length() > 0 ) ) {
      query += " and not exists ( select a from AuthCommonAffiliation as a where a.org = o and a.user.id = ? )"
      query_params.add(Long.parseLong(params.filter1));
    }

    ql = AuthCommonOrganisation.findAll(query, query_params, params)

    if ( ql ) {
      ql.each { id ->
        result.add([id:"${id.class.name}:${id.id}",text:"${id.displayName}"])
      }
    }

    result
  }

}
