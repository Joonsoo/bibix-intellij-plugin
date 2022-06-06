package com.giyeok.bibix.intellijplugin

import com.intellij.openapi.externalSystem.service.execution.AbstractExternalSystemTaskConfigurationType

class BibixExternalTaskConfigurationType :
  AbstractExternalSystemTaskConfigurationType(BibixConstants.SYSTEM_ID) {
}