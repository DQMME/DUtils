package de.dqmme.dutils.utils;

import de.dqmme.dutils.DUtils;

public class ConfigUtils {
    public void setReset(boolean reset) {
        DUtils.getPlugin(DUtils.class).configConf.set("Reset", reset);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).configConf, DUtils.getPlugin(DUtils.class).config);
    }

    public boolean getReset() {
        return DUtils.getPlugin(DUtils.class).configConf.getBoolean("Reset");
    }
}
