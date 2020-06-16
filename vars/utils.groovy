def isDevBranch() {
  return getEnvironment() == 'dev'
}
def getEnvironment() {
  if (BRANCH_NAME == 'master') { return 'production' }
  // this is here temporarily while we transition to envs/* based branches
  validBranches = ['qa', 'dev']
  if (validBranches.contains(BRANCH_NAME)) {
    return BRANCH_NAME
  }
  if (BRANCH_NAME.startsWith('envs/')) {
    return BRANCH_NAME.replace('envs/', '')
  }
  return null
}
