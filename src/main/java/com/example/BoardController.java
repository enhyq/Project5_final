package com.example;

import com.example.board.BoardDAO;
import com.example.board.BoardVO;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.ServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class BoardController {

    @Autowired
    BoardDAO boardDAO;

    @RequestMapping("/board/list")
    public String boardlist(Model model){
        System.out.println("BoardController - mapping from /board/list ");
        model.addAttribute("list", boardDAO.getBoardList());
        return "list";
    }

    @RequestMapping("/board/add")
    public String addPost(){
        System.out.println("BoardController - mapping from /board/list ");
        return "addpostform";
    }

    @RequestMapping("board/addok")
    public String addPostOK(BoardVO vo, MultipartRequest request, @RequestParam("file") MultipartFile file) throws UnsupportedEncodingException {
//        request.setCharacterEncoding("utf-8");
//        MultipartFile file = request.getParameter("file");
        request.getFile("image");

//        FileUpload upload = new FileUpload();
//        MemberVO u = upload.uploadPhoto(request); // returns MemberVO object

//        int i = memberDAO.insertMember(u);
//        String msg = "데이터 추가 성공!";
//        if(i == 0) msg = "[에러] 데이터 추가 실패 !";


        int i = boardDAO.insertBoard(vo);

        if(i == 0)
            System.out.println("데이터 추가 실패");
        else
            System.out.println("데이터 추가 성공!!!");
        return "redirect:list";
    }

    @RequestMapping("board/editform/{id}")
    public String editPost(@PathVariable("id") int id, Model model, ServletRequest request){

        System.out.println(request.getParameter("pw"));

        BoardVO boardVO = boardDAO.getBoard(id);

        model.addAttribute("boardVO", boardVO);
        return "editform";
    }

    @RequestMapping(value = "board/editok", method = RequestMethod.POST)
    public String editPostOK(BoardVO vo){
        int i = boardDAO.updateBoard(vo);
        if(i == 0)
            System.out.println("데이터 수정 실패!");
        else
            System.out.println("데이터 수정 성공!!!");
        return "redirect:list";
    }

    @RequestMapping("board/deleteok/{id}")
    public String deletePost(@PathVariable("id") int id){
        int i = boardDAO.deleteBoard(id);
        if(i == 0)
            System.out.println("데이터 삭제 실패");
        else
            System.out.println("데이터 삭제 성공!!!");
        return "redirect:../list";
    }

}