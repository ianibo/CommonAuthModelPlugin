package me.ianibbo.authcommon

class AuthCommonRole {

  String authority

  static mapping = {
    cache true
  }

  static constraints = {
    authority blank: false, unique: true
  }
}
