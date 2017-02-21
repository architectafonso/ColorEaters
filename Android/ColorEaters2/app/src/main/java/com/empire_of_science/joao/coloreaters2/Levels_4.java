package com.empire_of_science.joao.coloreaters2;

/**
 * Class that represents a level package with 20 levels.
 * Created by João on 15/12/2015.
 */
class Levels_4 {
    /**
     * Returns the level.
     * @param level The level to be returned.
     * @return String[] with a string for each line and characters for each piece, plus the number of moves.
     */
    public static String[] getLevel(int level){
        switch(level){
            case 1:
                return new String[]{
                        " wwrWR",
                        " wr RW",
                        "wr w r",
                        "wrw rw",
                        "wwrrww",
                        " www  ",
                        "8"
                };
            case 2:
                return new String[]{
                        " r  r ",
                        " BYYb ",
                        "yg  Gy",
                        " bYYB ",
                        " G  g ",
                        " R  R ",
                        "12"
                };
            case 3:
                return new String[]{
                        "Ybb rB",
                        "b    r",
                        "     r",
                        "yW    ",
                        "y   Wg",
                        "GywggR",
                        "9"
                };
            case 4:
                return new String[]{
                        " wyw  ",
                        "w w w ",
                        "ywYwy ",
                        "w W w ",
                        " wyw  ",
                        "      ",
                        "8"
                };

            case 5:
                return new String[]{
                        "      ",
                        "  W   ",
                        "w gb  ",
                        "rWg R ",
                        " bYBy ",
                        "  bGb ",
                        "7"

                };
            case 6:
                return new String[]{
                        "g    w",
                        " B  B ",
                        "      ",
                        "YYryRR",
                        " b  b ",
                        "W    G",
                        "20"
                };
            case 7:
                return new String[]{
                        "bybyby",
                        " byby ",
                        "  by  ",
                        " RYBG ",
                        "  gr  ",
                        " grgr ",
                        "9"
                };
            case 8:
                return new String[]{
                        "rybgry",
                        "yrgbyr",
                        "bgrybg",
                        "YB  GR",
                        " RGBY ",
                        "      ",
                        "11"
                };
            case 9:
                return new String[]{


                        "w   ww",
                        " w   w",
                        "  w   ",
                        "w  w w",
                        " w  w ",
                        "www  W",
                        "10"


                };

            case 10:
                return new String[]{
                        "      ",
                        "  gy  ",
                        " rBGr ",
                        " bYRb ",
                        "  gy  ",
                        "      ",
                        "6"
                };
            case 11:
                return new String[]{
                        "gygygy",
                        "yGygyg",
                        "gYgygy",
                        "yGygyg",
                        "gYgygy",
                        "ygygyg",
                        "9",
                };
            case 12:
                return new String[]{
                        " G    ",
                        " yb   ",
                        " gYB  ",
                        " yb   ",
                        " g    ",
                        "      ",
                        "4"
                };
            case 13:
                return new String[]{
                        "BybybY",
                        "ybyByb",
                        "bybYby",
                        "ybybyb",
                        "B  Yby",
                        "BYYbyb",
                        "8"
                };
            case 14:
                return new String[]{
                        "BYgByg",
                        "YGbYGb",
                        "GByGBy",
                        "BYGBYg",
                        "YgBYGB",
                        "GbYGBY",
                        "6"
                };
            case 15:
                return new String[]{
                        "Wywywy",
                        "ywywYw",
                        "wywYwy",
                        "yWywyw",
                        "wywywy",
                        "ywYwyW",
                        "10"
                };
            case 16:
                return new String[]{
                        "      ",
                        "      ",
                        "wrybgw",
                        "gryrwb",
                        "      ",
                        "RGBWYR",
                        "19",
                };
            case 17:
                return new String[]{

                        "W    G",
                        " w g  ",
                        "  g w ",
                        "w   g ",
                        " g w  ",
                        "g    w",
                        "17"
                };
            case 18:
                return new String[]{

                        "   G  ",
                        "   b  ",
                        "  YGy ",
                        "BgwbWB",
                        "  yGY ",
                        "   b  ",
                        "7"
                };
            case 19:
                return new String[]{

                        "ryryry",
                        "yRyrYr",
                        "ryryry",
                        "yryryr",
                        "rYryRy",
                        "yryryr",
                        "10"
                };
            case 20:
                return new String[]{

                        "brbrBr",
                        "rbrbrb",
                        "bRbrbr",
                        "rbrbrb",
                        "brBrbr",
                        "RbrbRb",
                        "9"




                };

            default:
                return new String[0];
        }
    }


}
