/*
 * Copyright (C) 2021 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.market.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.IntFunction;
import java.util.stream.Stream;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.MetaProperty;
import org.joda.beans.gen.BeanDefinition;
import org.joda.beans.gen.PropertyDefinition;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;
import org.joda.beans.impl.direct.DirectPrivateBeanBuilder;

import com.google.common.collect.ImmutableList;
import com.opengamma.strata.data.scenario.ScenarioArray;

/**
 * A currency-convertible scenario array for a single instance of CurrencyParameterSensitivities.
 * <p>
 * This contains a list of CurrencyParameterSensitivities, one amount for each scenario. The calculation runner is able
 * to convert the currency of the values if required.
 */
@BeanDefinition(builderScope = "private")
public final class CurrencyParameterSensitivitiesScenarioArray
    implements ScenarioArray<CurrencyParameterSensitivities>, ImmutableBean, Serializable {

  /**
   * The currency parameter sensitivities, one per scenario.
   */
  @PropertyDefinition(validate = "notNull")
  private final List<CurrencyParameterSensitivities> sensitivities;

  //-------------------------------------------------------------------------

  /**
   * Obtains an instance from the specified currency and array of values.
   *
   * @param sensitivities the sensitivities, one for each scenario
   * @return an instance with the specified currency and values
   */
  public static CurrencyParameterSensitivitiesScenarioArray of(List<CurrencyParameterSensitivities> sensitivities) {
    return new CurrencyParameterSensitivitiesScenarioArray(sensitivities);
  }

  /**
   * Obtains an instance using a function to create the entries.
   * <p>
   * The function is passed the index and returns the {@code MultiCurrencyAmount} for that index.
   *
   * @param size the number of elements, at least size one
   * @param valueFunction the function used to obtain each value
   * @return an instance initialized using the function
   */
  public static List<CurrencyParameterSensitivities> buildIt(
      int size,
      IntFunction<CurrencyParameterSensitivities> valueFunction) {
    List listOfSensis = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      listOfSensis.add(valueFunction.apply(i));
    }
    return listOfSensis;
  }

  /**
   * Obtains an instance using a function to create the entries.
   * <p>
   * The function is passed the scenario index and returns the value for that index.
   *
   * @param size the number of elements
   * @param amountFunction the function used to obtain each amount
   * @return an instance initialized using the function
   * @throws IllegalArgumentException is size is zero or less
   */
  public static CurrencyParameterSensitivitiesScenarioArray of(
      int size,
      IntFunction<CurrencyParameterSensitivities> amountFunction) {
    return CurrencyParameterSensitivitiesScenarioArray.of(buildIt(size, amountFunction));
  }

  //-------------------------------------------------------------------------
  @Override
  public int getScenarioCount() {
    return sensitivities.size();
  }

  @Override
  public CurrencyParameterSensitivities get(int index) {
    return sensitivities.get(index);
  }

  @Override
  public Stream<CurrencyParameterSensitivities> stream() {
    return sensitivities.stream();
  }

  //------------------------- AUTOGENERATED START -------------------------
  /**
   * The meta-bean for {@code CurrencyParameterSensitivitiesScenarioArray}.
   * @return the meta-bean, not null
   */
  public static CurrencyParameterSensitivitiesScenarioArray.Meta meta() {
    return CurrencyParameterSensitivitiesScenarioArray.Meta.INSTANCE;
  }

  static {
    MetaBean.register(CurrencyParameterSensitivitiesScenarioArray.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  private CurrencyParameterSensitivitiesScenarioArray(
      List<CurrencyParameterSensitivities> sensitivities) {
    JodaBeanUtils.notNull(sensitivities, "sensitivities");
    this.sensitivities = ImmutableList.copyOf(sensitivities);
  }

  @Override
  public CurrencyParameterSensitivitiesScenarioArray.Meta metaBean() {
    return CurrencyParameterSensitivitiesScenarioArray.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the currency parameter sensitivities, one per scenario.
   * @return the value of the property, not null
   */
  public List<CurrencyParameterSensitivities> getSensitivities() {
    return sensitivities;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      CurrencyParameterSensitivitiesScenarioArray other = (CurrencyParameterSensitivitiesScenarioArray) obj;
      return JodaBeanUtils.equal(sensitivities, other.sensitivities);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(sensitivities);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("CurrencyParameterSensitivitiesScenarioArray{");
    buf.append("sensitivities").append('=').append(JodaBeanUtils.toString(sensitivities));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code CurrencyParameterSensitivitiesScenarioArray}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code sensitivities} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<List<CurrencyParameterSensitivities>> sensitivities = DirectMetaProperty.ofImmutable(
        this, "sensitivities", CurrencyParameterSensitivitiesScenarioArray.class, (Class) List.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "sensitivities");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1226228605:  // sensitivities
          return sensitivities;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends CurrencyParameterSensitivitiesScenarioArray> builder() {
      return new CurrencyParameterSensitivitiesScenarioArray.Builder();
    }

    @Override
    public Class<? extends CurrencyParameterSensitivitiesScenarioArray> beanType() {
      return CurrencyParameterSensitivitiesScenarioArray.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code sensitivities} property.
     * @return the meta-property, not null
     */
    public MetaProperty<List<CurrencyParameterSensitivities>> sensitivities() {
      return sensitivities;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 1226228605:  // sensitivities
          return ((CurrencyParameterSensitivitiesScenarioArray) bean).getSensitivities();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code CurrencyParameterSensitivitiesScenarioArray}.
   */
  private static final class Builder extends DirectPrivateBeanBuilder<CurrencyParameterSensitivitiesScenarioArray> {

    private List<CurrencyParameterSensitivities> sensitivities = ImmutableList.of();

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1226228605:  // sensitivities
          return sensitivities;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 1226228605:  // sensitivities
          this.sensitivities = (List<CurrencyParameterSensitivities>) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public CurrencyParameterSensitivitiesScenarioArray build() {
      return new CurrencyParameterSensitivitiesScenarioArray(
          sensitivities);
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(64);
      buf.append("CurrencyParameterSensitivitiesScenarioArray.Builder{");
      buf.append("sensitivities").append('=').append(JodaBeanUtils.toString(sensitivities));
      buf.append('}');
      return buf.toString();
    }

  }

  //-------------------------- AUTOGENERATED END --------------------------
}
