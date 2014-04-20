package me.ianibbo.common

class AuthCommonRole {

  String authority

  static mapping = {
    table name:'auth_common_role', schema:'common', catalog:'common'
    cache true
  }



  static constraints = {
    authority blank: false, unique: true
  }
}
