
package com.app.domain;

import com.app.domain.model.ItemDetails;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {

  private static final String FAKE_ID = "8";

  private ItemDetails itemDetails;

  @Before
  public void setUp() {
    itemDetails = new ItemDetails();
    itemDetails.setId(FAKE_ID);
  }

  @Test
  public void testConstructorHappyCase() {
    final String id = itemDetails.getId();

    assertThat(id).isEqualTo(FAKE_ID);
  }
}
