package life.blog.community.Controller;

import life.blog.community.dto.AccessTokenDTO;
import life.blog.community.dto.GithubUser;
import life.blog.community.mapper.UserMapper;
import life.blog.community.model.User;
import life.blog.community.provider.GitHubProvide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvide gitHubProvide;
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response
                           ) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        String accessToken = gitHubProvide.getAccessToken(accessTokenDTO);
        GithubUser githubUser = gitHubProvide.getUser(accessToken);
        //System.out.println(githubUser.getName());

        if (githubUser != null) {
            User user=new User();
            //登录成功写Session

            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId() ));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtMoified(user.getGmtCreate());
            userMapper.insert(user);//存储数据库
            //登录成功写cookie
            response.addCookie(new Cookie("token", token));

     //    request.getSession().setAttribute("user", githubUser);



            return "redirect:/";


        } else {
            //登录失败，重新登录
            return "redirect:/";
        }
    }
}
