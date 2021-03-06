package org.zerock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.domain.CustomUser;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Setter(onMethod_= {@Autowired})
	private MemberMapper memberMapper;
	
	//UserDetails는 CustomUser를 User를 상속받아 작성한다. 이를 리턴해준다. 
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		log.warn("Load User By userName : "+userName);
		//username is userid
		MemberVO vo =memberMapper.read(userName);
		
		log.warn("quired by member mapper: "+vo);
		
		
		return vo == null ? null : new CustomUser(vo);
	}

}
