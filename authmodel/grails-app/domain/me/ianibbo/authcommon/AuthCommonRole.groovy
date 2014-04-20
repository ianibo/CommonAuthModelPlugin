package me.ianibbo.authcommon

class AuthCommonRole {

  String authority

  static mapping = {
    cache true
  }

  static mapping = {
    table name:'auth_common_role', schema:'auth', catalog:'auth'
  }



  static constraints = {
    authority blank: false, unique: true
  }
}
