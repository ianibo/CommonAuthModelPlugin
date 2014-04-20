package me.ianibbo.authcommon

class AuthCommonUser extends AuthCommonParty {

  transient springSecurityService

  String username
  String password
  boolean enabled = true
  boolean accountExpired
  boolean accountLocked
  boolean passwordExpired

  static transients = ['springSecurityService']

  static constraints = {
    username blank: false, unique: true
    password blank: false
  }

  static hasMany = [
    oAuthIDs : AuthCommonOAuthId
  ]

  static mapping = {
    password column: '`password`'
  }

  Set<AuthCommonRole> getAuthorities() {
    AuthCommonUserAuthCommonRole.findAllByAuthCommonUser(this).collect { it.AuthCommonRole } as Set
  }

  def beforeInsert() {
    encodePassword()
  }

  def beforeUpdate() {
    if (isDirty('password')) {
      encodePassword()
    }
  }

  protected void encodePassword() {
    password = springSecurityService.encodePassword(password)
  }
}
