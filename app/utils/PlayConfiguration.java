package utils;

import com.typesafe.config.Config;

public abstract class PlayConfiguration {

  protected final Config conf;

  public PlayConfiguration(Config conf) {
    this.conf = conf;
  }



}

