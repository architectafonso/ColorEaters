package com.empire_of_science.joao.coloreaters2;

/**
 * Class that represents a level package with 20 levels.
 * Created by João on 15/12/2015.
 */
 class Levels_6 {
    /**
     * Gets the level.
     * @param level The level to be returned.
     * @return String[] with a string for each line and characters for each piece, plus the number of moves.
     */
    public static String[] getLevel(int level){
        switch(level){
            case 1:
                return new String[]{
                        "yrBrbr",
                        "yryryy",
                        "Ryrbrb",
                        "bryRyy",
                        "Yrrbyr",
                        "brbrBr",
                        "16"

                };
            case 2:
                return new String[]{
                        "wrwrwr",
                        "rwRwrw",
                        "wrwrwr",
                        "rwrwrw",
                        "wrwrwr",
                        "rwrwrW",
                        "11"

                };
            case 3:
                return new String[]{
                        "Rgbr B",
                        " gbby ",
                        "brrybY",
                        "gyr   ",
                        "g  yr ",
                        "  Gy  ",
                        "10"

                };
            case 4:
                return new String[]{
                        " grywb",
                        "r     ",
                        "y    G",
                        "g    R",
                        "b   BY",
                        "w    W",
                        "32"


                };
            case 5:
                return new String[]{

                        "rybryb",
                        "brybry",
                        "ybrybr",
                        "brbbry",
                        "YrbRyb",
                        "BryyRy",
                        "22"
                };
            case 6:
                return new String[]{
                        "ryryry",
                        "Yryryr",
                        "ryryry",
                        "yryryr",
                        "ryryry",
                        "yryryR",
                        "14"

                };
            case 7: //Bom e difícil.
                return new String[]{
                        "GbRYgB",
                        "rygbry",
                        "gBryGb",
                        "rYgbRy",
                        "gbrygb",
                        "rYGBRy",
                        "18"

                };
            case 8:
                return new String[]{

                        "Bgrbyg",
                        "rrbgyW",
                        "bwgyrg",
                        "bwYgrw",
                        "bbwgry",
                        "RGrbwg",
                        "35"

                };
            case 9:
                return new String[]{

                        "y y y ",
                        " y y y",
                        "y y y ",
                        " y y y",
                        "y Y y ",
                        " y y y",
                        "9"
                };
            case 10:
                return new String[]{
                        "      ",
                        "      ",
                        " ygbyG",
                        " B g  ",
                        "b yb  ",
                        "g   gY",
                        "14"
                };
            case 11:
                return new String[]{
                        "gbgb  ",
                        "bgbg  ",
                        "gbYb  ",
                        "bgbg  ",
                        "GB    ",
                        "      ",
                        "7",
                };
            case 12:
                return new String[]{
                        "G     ",
                        " ybgr ",
                        " bYRb ",
                        " gRYg ",
                        " rbgy ",
                        "     B",
                        "14"
                };
            case 13:
                return new String[]{
                        "      ",
                        "   G  ",
                        "  yyb ",
                        " yBgYb",
                        "  yyb ",
                        "   g  ",
                        "5"
                };
            case 14:
                return new String[]{
                        "WRYrbg",
                        "RRYwbb",
                        "YYYrgw",
                        "wwryyy",
                        "BBgyrr",
                        "GBwyrw",
                        "31"
                };
            case 15:
                return new String[]{
                        "RyBgry",
                        "bgrybg",
                        "YrgbyR",
                        "gbyrgb",
                        "ryBgrY",
                        "bGrybg",
                        "31"
                };
            case 16:
                return new String[]{
                        "bwbwbW",
                        "wbwbwb",
                        "bwBwbw",
                        "wbwBwb",
                        "bwbwbw",
                        "Wbwbwb",
                        "10"
                };
            case 17:
                return new String[]{
                        "Bgwggy",
                        "gwrbrB",
                        "rgrgyw",
                        "rgyrwr",
                        "gbbygb",
                        "RYGrWg",
                        "30"
                };
            case 18:
                return new String[]{
                        "W  G w",
                        " r  w ",
                        "R bw  ",
                        "B wY  ",
                        " w  g ",
                        "w R  r",
                        "16"
                };
            case 19:
                return new String[]{
                        "w w wR",
                        "rw   w",
                        "brw  b",
                        "r rwbw",
                        "Br rw ",
                        "Wrrrrw",
                        "25"
                };
            case 20:
                return new String[]{

                        "WgryyB",
                        "rgrbwy",
                        "rgrbyr",
                        "gryGwb",
                        "grwygb",
                        "YbrgwR",
                        "32"
                };
            
            
            default:
                return new String[0];
        }
    }
}