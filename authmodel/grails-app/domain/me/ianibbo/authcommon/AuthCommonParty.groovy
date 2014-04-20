package me.ianibbo.authcommon

class AuthCommonParty {

  String displayName

  static mapping = {
    table name:'auth_common_party', schema:'auth', catalog:'auth'
  }

  static constraints = {
    displayName blank: false, unique: true
  }

}
