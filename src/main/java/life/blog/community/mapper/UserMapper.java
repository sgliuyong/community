package life.blog.community.mapper;

import life.blog.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    @Insert("insert into community.t_es_user(name,ACCOUNT_ID,TOKEN,GMT_CREATE,GMT_MODIFIED)values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtMoified})")
    void  insert(User user);
}
