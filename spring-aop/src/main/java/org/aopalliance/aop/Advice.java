/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.aopalliance.aop;

/**
 * AOP联盟的规范
 * Advice[可以理解为通知或者增强] 包括前置通知 before ,后置通知 after，焕然通知 around 等 .......。
 * Advice(增强)的接口。
 * <p>
 * Tag interface for Advice. Implementations can be any type
 * of advice, such as Interceptors.
 *
 * @author Rod Johnson
 * @version $Id: Advice.java,v 1.1 2004/03/19 17:02:16 johnsonr Exp $
 */
public interface Advice {

}
