package life.blog.community.mapper;

import life.blog.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into community.t_es_user(name,ACCOUNT_ID,TOKEN,GMT_CREATE,GMT_MODIFIED)values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtMoified})")
    void  insert(User user);
@Select("select * from community.t_es_user where TOKEN=#{token}")
    User finByToken(@Param("token") String token);
}
