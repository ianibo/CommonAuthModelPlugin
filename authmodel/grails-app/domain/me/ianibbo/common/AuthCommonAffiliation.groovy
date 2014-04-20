package me.ianibbo.common

import me.ianibbo.common.*;

class AuthCommonAffiliation {

  AuthCommonUser user
  AuthCommonOrganisation org
  RefdataValue status;  // 0=Pending, 1=Approved, 2=Rejected
  RefdataValue role  // 0=unspecified, 5=admin

  static mapping = {
    table name:'auth_common_affiliation', schema:'common'
  }

  static constraints = {
  }
}
