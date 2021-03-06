/*<license>
Copyright 2006 - $Date$ by the authors mentioned below.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</license>*/

package org.toryt_II.contract.bean;


import java.lang.reflect.Constructor;

import org.toryt.util_I.annotations.vcs.CvsInfo;
import org.toryt_II.contract.ConstructorContract;
import org.toryt_II.contract.TypeContract;


/**
 * Build method contracts JavaBean style. Construct an instance,
 * add conditions, and close.
 *
 * @author Jan Dockx
 */
@CvsInfo(revision = "$Revision$",
         date     = "$Date$",
         state    = "$State$",
         tag      = "$Name$")
public class ConstructorContractBean<_ImplicitArgument_>
    extends InstanceMethodContractBean<_ImplicitArgument_, Constructor<_ImplicitArgument_>>
    implements ConstructorContract<_ImplicitArgument_> {

  /*<construction>*/
  //------------------------------------------------------------------

  /**
   * @pre subject != null;
   * @pre Methods.methodKind(subject).isInstanceMethod();
   * @pre typeContract != null;
   * @post new.getSubject() == subject;
   * @post new.getTypeContract() == typeContract;
   */
  public ConstructorContractBean(Constructor<_ImplicitArgument_> subject, TypeContract<_ImplicitArgument_> typeContract) {
    super(subject, typeContract);
  }

  /*</construction>*/


  @Override
  protected Class<? extends Throwable>[] getExceptionTypes() {
    @SuppressWarnings("unchecked") Class<? extends Throwable>[] exceptionTypes =
        (Class<? extends Throwable>[])getSubject().getExceptionTypes();
    return exceptionTypes;
  }

}