/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.strata.market.surface;

import java.util.List;
import java.util.Optional;

import com.opengamma.strata.basics.date.DayCount;
import com.opengamma.strata.basics.date.Tenor;
import com.opengamma.strata.market.ValueType;

/**
 * Metadata about a surface and surface parameters.
 * <p>
 * Implementations of this interface are used to store metadata about a surface.
 * For example, a surface may be defined based on financial instruments.
 * The parameters might represent 1 day, 1 week, 1 month, 3 month and 6 months.
 * The metadata could be used to describe each parameter in terms of a {@link Tenor}.
 * <p>
 * This metadata can be used by applications to interpret the parameters of the surface.
 * For example, the scenario framework uses the data when applying perturbations.
 */
public interface SurfaceMetadata {

  /**
   * Gets the surface name.
   * 
   * @return the surface name
   */
  public abstract SurfaceName getSurfaceName();

  /**
   * Gets the x-value type, providing meaning to the x-values of the curve.
   * <p>
   * This type provides meaning to the x-values. For example, the x-value might
   * represent a year fraction, as represented using {@link ValueType#YEAR_FRACTION}.
   * 
   * @return the x-value type
   */
  public abstract ValueType getXValueType();

  /**
   * Gets the y-value type, providing meaning to the y-values of the curve.
   * <p>
   * This type provides meaning to the y-values.
   * 
   * @return the y-value type
   */
  public abstract ValueType getYValueType();

  /**
   * Gets the z-value type, providing meaning to the z-values of the curve.
   * <p>
   * This type provides meaning to the z-values.
   * 
   * @return the z-value type
   */
  public abstract ValueType getZValueType();

  /**
   * Gets the day count, optional.
   * <p>
   * If the x-value of the surface represents time as a year fraction, the day count
   * can be specified to define how the year fraction is calculated.
   * 
   * @return the day count
   */
  public abstract Optional<DayCount> getDayCount();

  /**
   * Gets metadata about each parameter underlying the surface.
   * <p>
   * If present, the parameter metadata should match the number of parameters on the surface.
   * 
   * @return the parameter metadata
   */
  public abstract Optional<List<SurfaceParameterMetadata>> getParameterMetadata();

  /**
   * Returns an instance where the parameter metadata has been changed.
   * <p>
   * The result will contain the specified parameter metadata.
   * A null value is accepted and causes the result to have no parameter metadata.
   * 
   * @param parameterMetadata  the new parameter metadata
   * @return the new surface metadata
   */
  public abstract SurfaceMetadata withParameterMetadata(List<SurfaceParameterMetadata> parameterMetadata);

}
