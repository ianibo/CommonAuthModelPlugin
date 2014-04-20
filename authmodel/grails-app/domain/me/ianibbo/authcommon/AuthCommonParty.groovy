package me.ianibbo.authcommon

class AuthCommonParty {

  String displayName

  static constraints = {
    displayName blank: false, unique: true
  }

}
