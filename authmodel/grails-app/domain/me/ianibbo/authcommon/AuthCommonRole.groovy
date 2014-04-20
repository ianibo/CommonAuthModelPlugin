package me.ianibbo.authcommon

class AuthCommonRole {

  String authority

  static mapping = {
    table name:'auth_common_role', schema:'auth', catalog:'auth'
    cache true
  }



  static constraints = {
    authority blank: false, unique: true
  }
}
