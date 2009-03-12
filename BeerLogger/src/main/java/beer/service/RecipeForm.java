package beer.service;

import org.hibernate.mapping.Collection;

import beer.domain.AdditiveIngredient;
import beer.domain.BarleyIngredient;
import beer.domain.FlavoringIngredient;
import beer.domain.HopIngredient;
import beer.domain.Recipe;
import beer.domain.YeastIngredient;

public class RecipeForm {

	private int id;
	private String name;
	private double initialGravity;
	private double finalGravity;
	private Recipe.Style style;
	private int batchSize;
	
	private HopIngredient[] hop = {new HopIngredient(), new HopIngredient(), new HopIngredient(), new HopIngredient(), 
			new HopIngredient(), new HopIngredient(), new HopIngredient(), new HopIngredient(), new HopIngredient(), 
			new HopIngredient()};
	
	public void setHop(HopIngredient[] hop) {
		this.hop = hop;
	}
	public HopIngredient[] getHop() {
		return hop;
	}
	
	private HopIngredient hop0 = new HopIngredient();
	private HopIngredient hop1 = new HopIngredient();
	private HopIngredient hop2 = new HopIngredient();
	private HopIngredient hop3 = new HopIngredient();
	private HopIngredient hop4 = new HopIngredient();
	private HopIngredient hop5 = new HopIngredient();
	private HopIngredient hop6 = new HopIngredient();
	private HopIngredient hop7 = new HopIngredient();
	private HopIngredient hop8 = new HopIngredient();
	private HopIngredient hop9 = new HopIngredient();
	private HopIngredient hop10 = new HopIngredient();
	private HopIngredient hop11 = new HopIngredient();
	private HopIngredient hop12 = new HopIngredient();
	private HopIngredient hop13 = new HopIngredient();
	private HopIngredient hop14 = new HopIngredient();
	private HopIngredient hop15 = new HopIngredient();
	private HopIngredient hop16 = new HopIngredient();
	private HopIngredient hop17 = new HopIngredient();
	private HopIngredient hop18 = new HopIngredient();
	private HopIngredient hop19 = new HopIngredient();
	
	private BarleyIngredient barley0 = new BarleyIngredient();
	private BarleyIngredient barley1 = new BarleyIngredient();
	private BarleyIngredient barley2 = new BarleyIngredient();
	private BarleyIngredient barley3 = new BarleyIngredient();
	private BarleyIngredient barley4 = new BarleyIngredient();
	
	private AdditiveIngredient additive0 = new AdditiveIngredient();
	private AdditiveIngredient additive1 = new AdditiveIngredient();
	private AdditiveIngredient additive2 = new AdditiveIngredient();
	private AdditiveIngredient additive3 = new AdditiveIngredient();
	private AdditiveIngredient additive4 = new AdditiveIngredient();
	
	private YeastIngredient yeast0 = new YeastIngredient();
	private YeastIngredient yeast1 = new YeastIngredient();
	private YeastIngredient yeast2 = new YeastIngredient();
	private YeastIngredient yeast3 = new YeastIngredient();
	private YeastIngredient yeast4 = new YeastIngredient();
	
	private FlavoringIngredient flavoring0 = new FlavoringIngredient();
	private FlavoringIngredient flavoring1 = new FlavoringIngredient();
	private FlavoringIngredient flavoring2 = new FlavoringIngredient();
	private FlavoringIngredient flavoring3 = new FlavoringIngredient();
	private FlavoringIngredient flavoring4 = new FlavoringIngredient();
	
	public RecipeForm(){};
	
	public RecipeForm(Recipe r) {
		
		id = r.getId();
		name = r.getName();
		initialGravity = r.getInitialGravity();
		finalGravity = r.getFinalGravity();
		style = r.getStyle();
		batchSize = r.getBatchSize();
		
		hop = r.getHops().toArray(new HopIngredient[0]);
		
		for (int i = 0; i < r.getHops().size(); i++) {
			switch (i) {
				case 0: hop0 = r.getHops().get(i); break;
				case 1: hop1 = r.getHops().get(i); break;
				case 2: hop2 = r.getHops().get(i); break;
				case 3: hop3 = r.getHops().get(i); break;
				case 4: hop4 = r.getHops().get(i); break;
				case 5: hop5 = r.getHops().get(i); break;
				case 6: hop6 = r.getHops().get(i); break;
				case 7: hop7 = r.getHops().get(i); break;
				case 8: hop8 = r.getHops().get(i); break;
				case 9: hop9 = r.getHops().get(i); break;
				case 10: hop10 = r.getHops().get(i); break;
				case 11: hop11 = r.getHops().get(i); break;
				case 12: hop12 = r.getHops().get(i); break;
				case 13: hop13 = r.getHops().get(i); break;
				case 14: hop14 = r.getHops().get(i); break;
				case 15: hop15 = r.getHops().get(i); break;
				case 16: hop16 = r.getHops().get(i); break;
				case 17: hop17 = r.getHops().get(i); break;
				case 18: hop18 = r.getHops().get(i); break;
				case 19: hop19 = r.getHops().get(i); break;
			}
		}
		
		for (int i = 0; i < r.getAdditives().size(); i++) {
			switch (i) {
				case 0: additive0 = r.getAdditives().get(i); break;
				case 1: additive1 = r.getAdditives().get(i); break;
				case 2: additive2 = r.getAdditives().get(i); break;
				case 3: additive3 = r.getAdditives().get(i); break;
				case 4: additive4 = r.getAdditives().get(i); break;
			}
		}
		
		for (int i = 0; i < r.getBarlies().size(); i++) {
			switch (i) {
				case 0: barley0 = r.getBarlies().get(i); break;
				case 1: barley1 = r.getBarlies().get(i); break;
				case 2: barley2 = r.getBarlies().get(i); break;
				case 3: barley3 = r.getBarlies().get(i); break;
				case 4: barley4 = r.getBarlies().get(i); break;
			}
		}
		
		for (int i = 0; i < r.getYeasts().size(); i++) {
			switch (i) {
				case 0: yeast0 = r.getYeasts().get(i); break;
				case 1: yeast1 = r.getYeasts().get(i); break;
				case 2: yeast2 = r.getYeasts().get(i); break;
				case 3: yeast3 = r.getYeasts().get(i); break;
				case 4: yeast4 = r.getYeasts().get(i); break;
			}
		}
		
		for (int i = 0; i < r.getFlavorings().size(); i++) {
			switch (i) {
				case 0: flavoring0 = r.getFlavorings().get(i); break;
				case 1: flavoring1 = r.getFlavorings().get(i); break;
				case 2: flavoring2 = r.getFlavorings().get(i); break;
				case 3: flavoring3 = r.getFlavorings().get(i); break;
				case 4: flavoring4 = r.getFlavorings().get(i); break;
			}
		}
				
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getInitialGravity() {
		return initialGravity;
	}

	public void setInitialGravity(double initialGravity) {
		this.initialGravity = initialGravity;
	}

	public double getFinalGravity() {
		return finalGravity;
	}

	public void setFinalGravity(double finalGravity) {
		this.finalGravity = finalGravity;
	}

	public Recipe.Style getStyle() {
		return style;
	}

	public void setStyle(Recipe.Style style) {
		this.style = style;
	}

	public int getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	public HopIngredient getHop0() {
		return hop0;
	}

	public void setHop0(HopIngredient hop0) {
		this.hop0 = hop0;
	}

	public HopIngredient getHop1() {
		return hop1;
	}

	public void setHop1(HopIngredient hop1) {
		this.hop1 = hop1;
	}

	public HopIngredient getHop2() {
		return hop2;
	}

	public void setHop2(HopIngredient hop2) {
		this.hop2 = hop2;
	}

	public HopIngredient getHop3() {
		return hop3;
	}

	public void setHop3(HopIngredient hop3) {
		this.hop3 = hop3;
	}

	public HopIngredient getHop4() {
		return hop4;
	}

	public void setHop4(HopIngredient hop4) {
		this.hop4 = hop4;
	}

	public HopIngredient getHop5() {
		return hop5;
	}

	public void setHop5(HopIngredient hop5) {
		this.hop5 = hop5;
	}

	public HopIngredient getHop6() {
		return hop6;
	}

	public void setHop6(HopIngredient hop6) {
		this.hop6 = hop6;
	}

	public HopIngredient getHop7() {
		return hop7;
	}

	public void setHop7(HopIngredient hop7) {
		this.hop7 = hop7;
	}

	public HopIngredient getHop8() {
		return hop8;
	}

	public void setHop8(HopIngredient hop8) {
		this.hop8 = hop8;
	}

	public HopIngredient getHop9() {
		return hop9;
	}

	public void setHop9(HopIngredient hop9) {
		this.hop9 = hop9;
	}

	public HopIngredient getHop10() {
		return hop10;
	}

	public void setHop10(HopIngredient hop10) {
		this.hop10 = hop10;
	}

	public HopIngredient getHop11() {
		return hop11;
	}

	public void setHop11(HopIngredient hop11) {
		this.hop11 = hop11;
	}

	public HopIngredient getHop12() {
		return hop12;
	}

	public void setHop12(HopIngredient hop12) {
		this.hop12 = hop12;
	}

	public HopIngredient getHop13() {
		return hop13;
	}

	public void setHop13(HopIngredient hop13) {
		this.hop13 = hop13;
	}

	public HopIngredient getHop14() {
		return hop14;
	}

	public void setHop14(HopIngredient hop14) {
		this.hop14 = hop14;
	}

	public HopIngredient getHop15() {
		return hop15;
	}

	public void setHop15(HopIngredient hop15) {
		this.hop15 = hop15;
	}

	public HopIngredient getHop16() {
		return hop16;
	}

	public void setHop16(HopIngredient hop16) {
		this.hop16 = hop16;
	}

	public HopIngredient getHop17() {
		return hop17;
	}

	public void setHop17(HopIngredient hop17) {
		this.hop17 = hop17;
	}

	public HopIngredient getHop18() {
		return hop18;
	}

	public void setHop18(HopIngredient hop18) {
		this.hop18 = hop18;
	}

	public HopIngredient getHop19() {
		return hop19;
	}

	public void setHop19(HopIngredient hop19) {
		this.hop19 = hop19;
	}

	public BarleyIngredient getBarley0() {
		return barley0;
	}

	public void setBarley0(BarleyIngredient barley0) {
		this.barley0 = barley0;
	}

	public BarleyIngredient getBarley1() {
		return barley1;
	}

	public void setBarley1(BarleyIngredient barley1) {
		this.barley1 = barley1;
	}

	public BarleyIngredient getBarley2() {
		return barley2;
	}

	public void setBarley2(BarleyIngredient barley2) {
		this.barley2 = barley2;
	}

	public BarleyIngredient getBarley3() {
		return barley3;
	}

	public void setBarley3(BarleyIngredient barley3) {
		this.barley3 = barley3;
	}

	public BarleyIngredient getBarley4() {
		return barley4;
	}

	public void setBarley4(BarleyIngredient barley4) {
		this.barley4 = barley4;
	}

	public AdditiveIngredient getAdditive0() {
		return additive0;
	}

	public void setAdditive0(AdditiveIngredient additive0) {
		this.additive0 = additive0;
	}

	public AdditiveIngredient getAdditive1() {
		return additive1;
	}

	public void setAdditive1(AdditiveIngredient additive1) {
		this.additive1 = additive1;
	}

	public AdditiveIngredient getAdditive2() {
		return additive2;
	}

	public void setAdditive2(AdditiveIngredient additive2) {
		this.additive2 = additive2;
	}

	public AdditiveIngredient getAdditive3() {
		return additive3;
	}

	public void setAdditive3(AdditiveIngredient additive3) {
		this.additive3 = additive3;
	}

	public AdditiveIngredient getAdditive4() {
		return additive4;
	}

	public void setAdditive4(AdditiveIngredient additive4) {
		this.additive4 = additive4;
	}

	public YeastIngredient getYeast0() {
		return yeast0;
	}

	public void setYeast0(YeastIngredient yeast0) {
		this.yeast0 = yeast0;
	}

	public YeastIngredient getYeast1() {
		return yeast1;
	}

	public void setYeast1(YeastIngredient yeast1) {
		this.yeast1 = yeast1;
	}

	public YeastIngredient getYeast2() {
		return yeast2;
	}

	public void setYeast2(YeastIngredient yeast2) {
		this.yeast2 = yeast2;
	}

	public YeastIngredient getYeast3() {
		return yeast3;
	}

	public void setYeast3(YeastIngredient yeast3) {
		this.yeast3 = yeast3;
	}

	public YeastIngredient getYeast4() {
		return yeast4;
	}

	public void setYeast4(YeastIngredient yeast4) {
		this.yeast4 = yeast4;
	}

	public FlavoringIngredient getFlavoring0() {
		return flavoring0;
	}

	public void setFlavoring0(FlavoringIngredient flavoring0) {
		this.flavoring0 = flavoring0;
	}

	public FlavoringIngredient getFlavoring1() {
		return flavoring1;
	}

	public void setFlavoring1(FlavoringIngredient flavoring1) {
		this.flavoring1 = flavoring1;
	}

	public FlavoringIngredient getFlavoring2() {
		return flavoring2;
	}

	public void setFlavoring2(FlavoringIngredient flavoring2) {
		this.flavoring2 = flavoring2;
	}

	public FlavoringIngredient getFlavoring3() {
		return flavoring3;
	}

	public void setFlavoring3(FlavoringIngredient flavoring3) {
		this.flavoring3 = flavoring3;
	}

	public FlavoringIngredient getFlavoring4() {
		return flavoring4;
	}

	public void setFlavoring4(FlavoringIngredient flavoring4) {
		this.flavoring4 = flavoring4;
	}
	
	
}
