/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.weld.tests.unit.deployment.structure.extensions;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessInjectionTarget;
import javax.enterprise.inject.spi.ProcessManagedBean;
import javax.enterprise.inject.spi.ProcessProducer;

public class Observer2 extends ObserverBase implements Extension
{
   
   public void observeAfterBeanDiscovery(@Observes AfterBeanDiscovery event)
   {
      this.afterBeanDiscoveryCalled = true;
   }
   
   public void observeBeforeBeanDiscovery(@Observes BeforeBeanDiscovery event, BeanManager beanManager)
   {
      this.beforeBeanDiscoveryCalled = true;
      this.beforeBeanDiscoveryBeanManager = beanManager;
   }
   
   public void observeAfterDeploymentValidation(@Observes AfterDeploymentValidation event)
   {
      afterDeploymentValidationCalled = true;
   }
   
   public void observeProcessProducer(@Observes ProcessProducer<Foo, String> event)
   {
      processProducerCalled = true;
   }
   
   public void observeProcessInjectionTarget(@Observes ProcessInjectionTarget<Foo> event)
   {
      processInjectionTargetCalled = true;
   }
   
   public void observeProcessManagedBean(@Observes ProcessManagedBean<Foo> event)
   {
      processManagedBeanCalled = true;
   }

}
