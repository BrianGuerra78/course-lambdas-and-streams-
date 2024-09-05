package com.debuggeando_ideas.switch_case;

public class SwitchCaseLamda {
    public static void main(String[] args) {
        var result = switch("UNO"){
            case "UNO" -> "1";
            case "DOS" -> "2";
            case "TRES" -> "3";
            default -> "No encontrado";
        };
        System.out.println(result);
    }
}
