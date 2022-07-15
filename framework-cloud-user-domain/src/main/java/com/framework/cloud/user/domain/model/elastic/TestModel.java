package com.framework.cloud.user.domain.model.elastic;

import com.framework.cloud.elasticsearch.annotation.ElasticDeclare;
import com.framework.cloud.elasticsearch.annotation.ElasticId;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 *
 *
 * @author wusiwei
 */
@Data
@FieldNameConstants
@ElasticDeclare(indexName = "index-test-model", shards = 3, replicas = 2)
public class TestModel {

    @ElasticId
    private String id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String name;

    @Field(type = FieldType.Long)
    private Long createTime;

    @Field(type = FieldType.Nested)
    private List<TestDetailModel> detailList;
}
