package com.fischl.tools;

import jakarta.servlet.http.HttpServletRequest;

public class Layout {
    private static final String _LAYOUT = "_layout.jsp";
    private HttpServletRequest req = null;
    private String page = null;
    public Popup popup = null;

    public Layout(HttpServletRequest req) {
        this.req = req;
    }
    public void hasPopup(Theme theme, String message) {
        this.popup = new Popup(theme, message);
    }
    public void applyTo(String page) {
        this.page = page;
    }
    public String getPageURI() {
        if (req != null && page != null) {
            req.setAttribute("body-content", page);
            req.setAttribute("layout", this);
        }
        return "/" + _LAYOUT;
    }
    public enum Theme {
        success, fail, normal
    }
    public class Popup{
        public String popupMessage = null;
        public Theme theme = null;
        public Popup(){}
        public  Popup(Theme theme, String message) {
            this.theme = theme;
            this.popupMessage = message;
        }
        public String getColor() {
            return theme==Theme.success? "green" : theme==Theme.fail? "red" : theme==Theme.normal? "black" : "yellow";
        }
    }
}
