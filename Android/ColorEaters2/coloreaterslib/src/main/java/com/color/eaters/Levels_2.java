package com.color.eaters;

/**
 * Class that represents a level package with 20 levels.
 * Created by João on 15/12/2015.
 */
class Levels_2 {
    /**
     * Returns the level.
     * @param level The level to be returned.
     * @return String[] with a string for each line and characters for each piece, plus the number of moves.
     */
    public static String[] getLevel(int level) {
        switch (level) {

            case 1:
                return new String[]{
                        "      ",
                        "  bg  ",
                        "  gb  ",
                        " B  G ",
                        "  bg  ",
                        "  gb  ",
                        "4"
                };
            case 2:
                return new String[]{
                        "      ",
                        "r     ",
                        "Y    R",
                        "r    y",
                        "Y    R",
                        "     y",
                        "10"
                };
            case 3:
                return new String[]{
                        "   Y  ",
                        "  BGy ",
                        "   bg ",
                        "      ",
                        "R    Y",
                        " ryry ",
                        "5"
                };
            case 4:
                return new String[]{
                        "      ",
                        " Y  R ",
                        " R  Y ",
                        "ryryr ",
                        "rryyy ",
                        "      ",
                        "2"
                };
            case 5:
                return new String[]{

                        "      ",
                        " rgyG ",
                        " YrgR ",
                        "      ",
                        "      ",
                        "      ",
                        "3"
                };
            case 6:
                return new String[]{
                        "  W   ",
                        "  Rw  ",
                        "  Grw ",
                        "   grw",
                        "    gr",
                        "     g",
                        "12"
                };
            case 7:
                return new String[]{
                        "r RR  ",
                        "br  rb",
                        "R BB R",
                        "R    R",
                        " rBBr ",
                        "bbRRbb",
                        "6"
                };
            case 8:
                return new String[]{
                        " r  g ",
                        "r    g",
                        "  YB  ",
                        "  GR  ",
                        "b    y",
                        " b  y ",
                        "12"
                };
            case 9:
                return new String[]{
                        "      ",
                        "      ",
                        " yRY  ",
                        " gyG  ",
                        "  ry  ",
                        "      ",
                        "3"
                };
            case 10:
                return new String[]{
                        "g YR w",
                        "g RY w",
                        "g YR w",
                        "g RY w",
                        "y WW r",
                        "y GG r",
                        "8"
                };
            case 11:
                return new String[]{
                        "  ww w",
                        "    w ",
                        "     w",
                        "   W w",
                        "    w ",
                        "   w w",
                        "5"
                };
            case 12:
                return new String[]{
                        "Br  gR",
                        "r    g",
                        "     w",
                        "W     ",
                        "b    y",
                        "Yb  yG",
                        "16"
                };
            case 13:
                return new String[]{
                        "bbbYbR",
                        "byyByb",
                        "byryBY",
                        "byrryb",
                        "byyyyb",
                        "Wbbbbb",
                        "5"
                };
            case 14:
                return new String[]{
                        "  g   ",
                        " gBy  ",
                        "bYGBy ",
                        " bYg  ",
                        "  g   ",
                        "      ",
                        "4"
                };
            case 15:
                return new String[]{

                        "Y     ",
                        "bG    ",
                        "rwR   ",
                        "g  W  ",
                        "y   B ",
                        "      ",
                        "10"
                };
            case 16:
                return new String[]{
                        "bbbbbb",
                        "bbbbbb",
                        "gWgYrW",
                        "gBgBrr",
                        "ggyRyy",
                        "ggBGyy",
                        "4"

                };
            case 17:
                return new String[]{

                        "      ",
                        " ygb  ",
                        " GBY  ",
                        " byg  ",
                        "      ",
                        "      ",
                        "4"
                };
            case 18:
                return new String[]{

                        "      ",
                        "  WR  ",
                        "  YB  ",
                        "grbywg",
                        "  YB  ",
                        "  GG  ",
                        "10"
                };
            case 19:
                return new String[]{

                        "  Yg w",
                        "w    r",
                        "b W  w",
                        "w BW  ",
                        "  R  w",
                        "w yG  ",
                        "17"

                };
            case 20:
                return new String[]{
                        "      ",
                        "      ",
                        "  gYR ",
                        "  BGb ",
                        "  yr  ",
                        "      ",
                        "3"
                };
            default:
                return new String[]{};
        }
    }
}
