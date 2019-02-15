package com.myMaven.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myMaven.mybatis.mapper.MemberService;
import com.myMaven.mybatis.unit.PagingAction;
import com.myMaven.mybatis.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Resource(name="mService") //Autowired�� ���� ����.. �̸����� ã�´�
	private MemberService mService;
	
	@Resource(name="page")
	private PagingAction page;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//insert-form
	@RequestMapping("insert")
	public String insert() {
		return "memberInsert";
	}
	
	//insert
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insert(MemberVO user) {
		mService.insert(user);
		return "redirect:list";
	}
	
	//list
//	@RequestMapping("list")
//	public String getList(Model model, String pageNum){
//		List<MemberVO> vo = mService.getList();
//		int count = vo.size(); //�Խñ� ����
//		model.addAttribute("vo",vo);
//		return "list"; //���⼭ return�� //ó���ϸ� �����ִ� RequestMapping "list" ������ �ڵ����� list.jps�� ã�ư���. �������� ���� �ϴ��� �׳� ������(���� �Ǿ� ����)
//	}
	
	@RequestMapping("list")
	public String list(Model model, String pageNum) {
		int pageSize = 5;
		if(pageNum==null)pageNum ="1";
		int currentPage = Integer.parseInt(pageNum);
		
		int count = mService.getCount();
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = startRow + pageSize-1;
		if(endRow > count) endRow = count;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		
		List<MemberVO> userlist = mService.getList(hm);
		String pageHtml = page.paging(count, pageSize, currentPage);
		model.addAttribute("vo", userlist);
		model.addAttribute("count", count);
		model. addAttribute("pageHtml", pageHtml);
		return "list";
	}
	
	//delete
	@RequestMapping("delete")
	public String delete(String id) {
		mService.delete(id);
		return "redirect:list";
	}
	
	//detatil
	@RequestMapping("findById")
	public String findById(String id, Model model) {
		MemberVO vo = mService.findById(id);
		model.addAttribute("vo", vo);
		return "detail";
	}
	
	//update
	@RequestMapping("update")
	public String update(MemberVO vo, Model model) {
		mService.update(vo);
		return "redirect:list";
	}
	
}
