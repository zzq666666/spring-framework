/*
 * Copyright 2002-2018 the original author or authors.
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

package org.springframework.beans.factory;

/**
 * Extension of the {@link FactoryBean} interface. Implementations may
 * indicate whether they always return independent instances, for the
 * case where their {@link #isSingleton()} implementation returning
 * {@code false} does not clearly indicate independent instances.
 *
 * <p>Plain {@link FactoryBean} implementations which do not implement
 * this extended interface are simply assumed to always return independent
 * instances if their {@link #isSingleton()} implementation returns
 * {@code false}; the exposed object is only accessed on demand.
 *
 * <p><b>NOTE:</b> This interface is a special purpose interface, mainly for
 * internal use within the framework and within collaborating frameworks.
 * In general, application-provided FactoryBeans should simply implement
 * the plain {@link FactoryBean} interface. New methods might be added
 * to this extended interface even in point releases.
 *
 * @author Juergen Hoeller
 * @since 2.0.3
 * @param <T> the bean type
 * @see #isPrototype()
 * @see #isSingleton()
 */
public interface SmartFactoryBean<T> extends FactoryBean<T> {

	/**
	 * Is the object managed by this factory a prototype? That is,
	 * will {@link #getObject()} always return an independent instance?
	 * <p>The prototype status of the FactoryBean itself will generally
	 * be provided by the owning {@link BeanFactory}; usually, it has to be
	 * defined as singleton there.
	 * <p>This method is supposed to strictly check for independent instances;
	 * it should not return {@code true} for scoped objects or other
	 * kinds of non-singleton, non-independent objects. For this reason,
	 * this is not simply the inverted form of {@link #isSingleton()}.
	 * <p>The default implementation returns {@code false}.
	 * @return whether the exposed object is a prototype
	 * @see #getObject()
	 * @see #isSingleton()
	 */
	default boolean isPrototype() {
		return false;
	}

	/**
	 * 此FactoryBean是否期望进行急切的初始化，即渴望初始化自己以及期望对其单例对象（如果有）进行渴望的初始化？
	 *<p>不希望标准FactoryBean急于初始化：
	 * 它的{@link #getObject（）}仅在实际访问时被调用，即使是单例对象也是如此。 从这里返回{@code true}
	 * 方法建议{@link #getObject（）}应该被急切地调用
	 * 也热切地应用后处理器。 对于{@link #isSingleton（）单例}对象，这可能是有道理的，特别是如果后处理器希望在启动时应用。
	 * <p>默认实现返回{@code false}。
	 *
	 *
	 * 默认情况下，该FactoryBean是懒加载的.
	 *
	 * Does this FactoryBean expect eager initialization, that is,
	 * eagerly initialize itself as well as expect eager initialization
	 * of its singleton object (if any)?
	 * <p>A standard FactoryBean is not expected to initialize eagerly:
	 * Its {@link #getObject()} will only be called for actual access, even
	 * in case of a singleton object. Returning {@code true} from this
	 * method suggests that {@link #getObject()} should be called eagerly,
	 * also applying post-processors eagerly. This may make sense in case
	 * of a {@link #isSingleton() singleton} object, in particular if
	 * post-processors expect to be applied on startup.
	 * <p>The default implementation returns {@code false}.
	 * @return whether eager initialization applies
	 * @see org.springframework.beans.factory.config.ConfigurableListableBeanFactory#preInstantiateSingletons()
	 */
	default boolean isEagerInit() {
		return false;
	}

}
