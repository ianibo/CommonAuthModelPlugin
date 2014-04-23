package me.ianibbo.common

class AuthCommonParty {

  String displayName
  String notes

  static mapping = {
    table name:'auth_common_party', schema:'common'
    notes type:'text'
  }

  static constraints = {
    displayName nullable:true, blank: true
    notes nullable:true, blank: true
  }

}
