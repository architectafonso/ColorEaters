package com.color.eaters;

/**
 * Class that represents an level package with 20 levels.
 * Created by João on 15/12/2015.
 */
class Levels_1 {
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
                        " gB   ",
                        " bG   ",
                        "      ",
                        "      ",
                        "      ",
                        "1"
                };
            case 2:
                return new String[]{
                        "bbbbbb",
                        "bbbbbb",
                        "  G   ",
                        "   B  ",
                        "gggggg",
                        "gggggg",
                        "2"
                };
            case 3:
                return new String[]{
                        "      ",
                        "      ",
                        "  GbG ",
                        "  BgB ",
                        "      ",
                        "      ",
                        "1"
                };
            case 4:
                return new String[]{
                        "      ",
                        "      ",
                        "  g   ",
                        "  BGb ",
                        "      ",
                        "      ",
                        "1"
                };
            case 5:
                return new String[]{
                        "      ",
                        "      ",
                        "  gb  ",
                        "  bg  ",
                        "  GB  ",
                        "      ",
                        "1"
                };
            case 6:
                return new String[]{
                        "ggB   ",
                        "gb    ",
                        "gb    ",
                        "gbG   ",
                        "gb    ",
                        "gb    ",
                        "2"
                };
            case 7:
                return new String[]{
                        "      ",
                        "      ",
                        "  GYB ",
                        "  yb  ",
                        "  g   ",
                        "      ",
                        "2"
                };
            case 8:
                return new String[]{
                        "ggggg ",
                        "  b   ",
                        "  b   ",
                        "bbGbb ",
                        "  b   ",
                        "  b B ",
                        "3"
                };
            case 9:
                return new String[]{
                        "G     ",
                        "bgbgbg",
                        "bgbgbg",
                        "bgbgbg",
                        "bgbgbg",
                        "     B",
                        "10"
                };
            case 10:
                return new String[]{
                        "   gg ",
                        " G Wy ",
                        " bY y ",
                        " b B  ",
                        "      ",
                        "      ",
                        "4"
                };
            case 11:
                return new String[]{
                        "      ",
                        "G     ",
                        "bgbgbg",
                        "gbgbgb",
                        "B     ",
                        "      ",
                        "3"
                };
            case 12:
                return new String[]{
                        "      ",
                        " y    ",
                        "  R   ",
                        "   Y  ",
                        "    r ",
                        "      ",
                        "5"
                };
            case 13:
                return new String[]{
                        "  Wr  ",
                        "  Rg  ",
                        "  Gb  ",
                        "  By  ",
                        "  Yr  ",
                        "  Rw  ",
                        "5"
                };
            case 14:
                return new String[]{
                        "byy   ",
                        "yb B  ",
                        "yb    ",
                        "yb    ",
                        "ybY   ",
                        "bbb   ",
                        "4"
                };
            case 15:
                return new String[]{
                        "  bggg",
                        "  byyg",
                        "  R g ",
                        "  B  G",
                        "  Y   ",
                        "  r g ",
                        "7"
                };
            case 16:
                return new String[]{
                        "      ",
                        " Wgbg ",
                        " BRG  ",
                        " w  r ",
                        "      ",
                        "      ",
                        "4"
                };
            case 17:
                return new String[]{
                        "      ",
                        "RY r  ",
                        " ry   ",
                        " yrY  ",
                        "   R  ",
                        "      ",
                        "3"
                };
            case 18:
                return new String[]{
                        "      ",
                        "   Y  ",
                        "BRyrbR",
                        "      ",
                        "      ",
                        "      ",
                        "3"
                };
            case 19:
                return new String[]{
                        "      ",
                        "  GyW ",
                        "  RbY ",
                        "  YgR ",
                        "  WyB ",
                        "      ",
                        "3"
                };
            case 20:
                return new String[]{
                        "rrrrrr",
                        "bbbbbb",
                        "gggggb",
                        " BgRgb",
                        "brrbbb",
                        "G     ",
                        "7"
                };
            default:
                return new String[]{};
        }
    }
}
