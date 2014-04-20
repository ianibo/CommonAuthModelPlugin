package me.ianibbo.common

class AuthCommonParty {

  String displayName

  static mapping = {
    table name:'auth_common_party', schema:'common'
  }

  static constraints = {
    displayName nullable:true, blank: true, unique: false
  }

}
