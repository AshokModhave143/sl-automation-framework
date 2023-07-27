package com.sltest.core;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.strategyX.pageObjects.ActionPage;
import com.strategyX.pageObjects.ApprovalsPage;
import com.strategyX.pageObjects.FocusGoalPage;
import com.strategyX.pageObjects.IdeasAndProbsPage;
import com.strategyX.pageObjects.RiskPage;
import com.strategyX.pageObjects.SuccessFactorPage;
import com.strategyX.pageObjects.TacticalProjectsPage;

public class PageObjectManager {
	private WebDriver driver;
	
	// StrategyX
	private SuccessFactorPage successFactorPage;
	private FocusGoalPage focusGoalPage;
	private RiskPage riskPage;
	private TacticalProjectsPage tacticalProjectsPage;
	private IdeasAndProbsPage ideasAndProbsPage;
	private ApprovalsPage approvalsPage;
	private ActionPage actionPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public ActionPage getActionPage() throws IOException {
		return (actionPage == null) ? actionPage = new ActionPage(driver) : actionPage;

	}
	
	
	public SuccessFactorPage getSuccessFactorPage() throws IOException {
		return (successFactorPage == null) ? successFactorPage = new SuccessFactorPage(driver) : successFactorPage;

	}
	
	public FocusGoalPage getFocusGoalPage() throws IOException {
		return (focusGoalPage == null) ? focusGoalPage = new FocusGoalPage(driver) : focusGoalPage;
	}
	
	public RiskPage getRiskPage() throws IOException {
		return (riskPage == null) ? riskPage = new RiskPage(driver) : riskPage;
	}
	
	public IdeasAndProbsPage getIdeasAndProbsPage() throws IOException {
		return (ideasAndProbsPage == null) ? ideasAndProbsPage = new IdeasAndProbsPage(driver) : ideasAndProbsPage;
	}
	
	public TacticalProjectsPage getTacticalProjectsPage() throws IOException {
		return (tacticalProjectsPage == null) ? tacticalProjectsPage = new TacticalProjectsPage(driver) : tacticalProjectsPage;
	}
	
	public ApprovalsPage getApprovalsPage() throws IOException {
		return (approvalsPage == null) ? approvalsPage = new ApprovalsPage(driver) : approvalsPage;
	}	

}
