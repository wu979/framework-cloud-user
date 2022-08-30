package com.framework.cloud.user.domain.model.elastic;

import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author wusiwei
 */
@Data
@FieldNameConstants
public class TestDetailModel {

    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String skuName;

    @Field(type = FieldType.Integer)
    private Integer stock;
}
