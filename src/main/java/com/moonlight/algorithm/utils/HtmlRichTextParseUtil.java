package com.moonlight.algorithm.utils;

import javax.swing.text.html.parser.ParserDelegator;
import java.io.*;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.*;

/**
 * 功能描述:
 * 处理html富文本，将html富文本转换为纯文本
 * 主要逻辑:
 * <p>
 * 注意事项:
 *
 * @author Moonlight
 * @date 2021-10-11 10:22
 */
public class HtmlRichTextParseUtil extends HTMLEditorKit.ParserCallback {

    public static void main(String[] args) {
        String s = "<p><h4>dwdwefwfwfwfwfw<em>fwf</em>wfwfwef<strong>全球恶气fwf</strong>对方前</h4><h4>锋<span class=\"ql-font-serif\">访问方法</span><span class=\"ql-font-serif\" style=\"color: rgb(255, 153, 0);\">微软</span></h4></p>";
        System.out.println(getContent(s));
    }

    private static HtmlRichTextParseUtil html2Text = new HtmlRichTextParseUtil();

    StringBuffer text;

    public HtmlRichTextParseUtil() {
    }

    public void parse(String str) throws IOException {
        try (InputStream inputStream = new ByteArrayInputStream(str.getBytes()); Reader reader = new InputStreamReader(inputStream)) {
            text = new StringBuffer();
            new ParserDelegator().parse(reader, this, Boolean.TRUE);
        }
    }

    @Override
    public void handleText(char[] text, int pos) {
        this.text.append(text);
    }

    private String getText() {
        return text.toString();
    }

    public static String getContent(String str) {
        try {
            html2Text.parse(str);
        } catch (IOException e) {
            return null;
        }
        return html2Text.getText();
    }
}
