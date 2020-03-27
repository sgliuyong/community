package life.blog.community.Controller;

import life.blog.community.dto.AccessTokenDTO;
import life.blog.community.dto.GithubUser;
import life.blog.community.provider.GitHubProvide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvide gitHubProvide;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("a2843338bb2f8be87d17");
        accessTokenDTO.setClient_secret("673d1a31182c911793923b09c8c5ebc909d44e88");
        accessTokenDTO.setRedirect_uri("http://localhost:8889/callback");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        String accessToken = gitHubProvide.getAccessToken(accessTokenDTO);
        GithubUser user = gitHubProvide.getUser(accessToken);

        System.out.println(user.getName());
        return "index";

    }
}
