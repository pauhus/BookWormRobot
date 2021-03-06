package com.academy.BookwormRobot.bookShop;

import org.apache.log4j.Logger;

import com.academy.BookwormRobot.enums.BookShopTypes;
import com.academy.BookwormRobot.utils.HtmlUtils;
import com.academy.BookwormRobot.utils.StringUtils;

/**
 * Glowna Ksiegarnia Naukowa book shop
 * 
 * @author Paulina
 *
 */
public class GKNBookShop extends BookShop {

	private final static Logger logger = Logger.getLogger(GKNBookShop.class);

	private final static String URL = "http://www.eksiegarnia.pl/lokal/;s,promocje";

	private final static String titleDivName = "<table class=\"tabela_podstrona\">";

	public GKNBookShop() {
		super(URL, logger);
	}

	/**
	 * Method which downloads title and additional info from default div name.
	 * In addition we need to remove unnecessary signs from it.
	 * 
	 * @return
	 */
	public String getTitleOfDiscountedBook() {
		String title = HtmlUtils.getInnerContent(titleDivName, URL);
		String s1 = title.replaceAll("\\s", " ").trim().replaceAll("cena.*?\\s+\\s+\\s+", "");
		return s1;
	}

	@Override
	public int getType() {
		return BookShopTypes.glownaKsiegarniaNaukowa.getType();
	}

	@Override
	public void getInfoOfDiscountedBook() {
		if (StringUtils.isNullOrEmpty(getTitleOfDiscountedBook())) {
			logger.error("Nie mozna pobrac informacji o ksiazce!");
		} else {
			logger.info(getTitleOfDiscountedBook() + "\n");
		}
	}

}
