package me.ianibbo.authcommon

import me.ianibbo.authcommon.*;

class AuthCommonAffiliation {

  AuthCommonUser user
  AuthCommonOrg org
  // RefdataValue status;  // 0=Pending, 1=Approved, 2=Rejected
  // RefdataValue role  // 0=unspecified, 5=admin

  static constraints = {
  }
}
