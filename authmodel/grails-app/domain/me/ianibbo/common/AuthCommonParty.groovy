package me.ianibbo.common

class AuthCommonParty {

  String displayName
  String notes
  String email
  String twitter
  String facebook
  Boolean emailConfirmed

  static mapping = {
    table name:'auth_common_party', schema:'common'
    notes type:'text'
  }

  static constraints = {
    displayName nullable:true, blank: true
    notes nullable:true, blank: true
    email nullable:true, blank:true
    twitter nullable:true, blank:true
    facebook nullable:true, blank:true
    emailConfirmed nullable:true, blank:true
  }

}
