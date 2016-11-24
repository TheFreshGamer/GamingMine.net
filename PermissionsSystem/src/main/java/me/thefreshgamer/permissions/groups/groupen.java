package me.thefreshgamer.permissions.groups;

/**
 * Created by SpielKind on 21.10.2016.
 */
public enum  groupen {

        HeadAdmin("HeadAdmin"),
        ADMIN("Admin"),
        Dev("Dev"),
        Srmod("Srmod"),
        Mod("Mod"),
        Sup("Sup"),
        Guide("Guide"),
        Builder("Builder"),
        Youtuber("Youtuber"),
        Premium("Premium"),
        PremiumPlus("PremiumPlus"),
        NF("NF"),
        Spieler("Spieler");

		private String name;
			private groupen(String name) {
     this.name = name;
  }  
  public String getName() {    
  return this.name;
   }
 }
