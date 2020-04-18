package life.blog.community.mapper;

import life.blog.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface QuestMapper {
    @Insert("insert into community.question(title,description,gmt_create,gmt_modified,creator,tag)VALUES(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    public  void  create(Question question);
}
