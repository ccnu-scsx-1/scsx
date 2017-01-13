package com.ccnu.scsx.mapper;

import com.ccnu.scsx.annotation.Mapper;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.model.ContactFeed;
import com.ccnu.scsx.model.ScsxFeedContact;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScsxFeedContactMapper extends BaseMapper<ScsxFeedContact> {

  ScsxFeedContact selectByPrimaryKey(String id);

  List<String> getFeedBackId(@Param("role") int role, @Param("userId") String userId);

  List<ContactFeed> getSomeThing(@Param("role") int role, @Param("userId") String userId);

}