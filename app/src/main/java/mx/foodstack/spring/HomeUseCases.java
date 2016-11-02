package mx.foodstack.spring;

import javax.inject.Inject;

import mx.foodstack.menu.entityBoundaries.IMenuRepository;

/**
 * Created by eecheverria on 11/1/2016.
 */

public class HomeUseCases {
    private IMenuRepository mMenuRepository;

    public HomeUseCases(IMenuRepository menuRepository) {
        mMenuRepository = menuRepository;
    }

    public String showHighlightsCarousel() {
        return "Repository is " + mMenuRepository;
    }
}