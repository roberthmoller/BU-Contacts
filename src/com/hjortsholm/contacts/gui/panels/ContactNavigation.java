package com.hjortsholm.contacts.gui.panels;

import com.hjortsholm.contacts.gui.controls.CategorisedListView;
import com.hjortsholm.contacts.gui.controls.ContactNavigationTab;
import com.hjortsholm.contacts.gui.controls.ScrollableView;
import com.hjortsholm.contacts.gui.parents.CustomGrid;
import com.hjortsholm.contacts.gui.style.Style;
import com.hjortsholm.contacts.models.Contact;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.util.*;
import java.util.function.Consumer;

/**
 * <h1>Contact Navigation</h1>
 * This is a custom list that takes a list of contacts, sorts them
 * and groups them by first letter in display title.
 *
 * @author Robert Moeller s5069583
 * @version 1.0
 * @see ContactNavigationTab
 * @see Contact
 * @since 10/04/2018
 */
public class ContactNavigation extends AnchorPane {

    private ContactNavigationTab selectedNavigationTab;
    private Consumer<ContactNavigationTab> onTabSelectedEvent;

    private CustomGrid contactNavigation;
    private ArrayList<CategorisedListView> listViews;

    private TextField searchField;
    private Consumer<String[]> onSearch;

    private ArrayList<Contact> contacts;

    /**
     * Creates all controls and binds events.
     */
    public ContactNavigation() {
        this.contacts = new ArrayList<>();
        Style.addStylesheet(this, "ContactNavigation");
        Style.addGenericStyleClass(this);

        this.contactNavigation = new CustomGrid();
        this.searchField = new TextField();
        AnchorPane.setTopAnchor(this.searchField, 10.);
        AnchorPane.setRightAnchor(this.searchField, 15.);
        AnchorPane.setLeftAnchor(this.searchField, 15.);


        this.searchField.setPromptText("Search");
        this.searchField.setOnKeyReleased(this::onSearch);
        Style.addStylesheet(this.searchField, "TextFields");
        Style.addStyleClass(this.searchField, "SearchField");

        ScrollableView scrollContainer = new ScrollableView();
        AnchorPane.setBottomAnchor(scrollContainer, 0.);
        AnchorPane.setTopAnchor(scrollContainer, 40.);

        scrollContainer.setContent(this.contactNavigation);
        this.getChildren().add(this.searchField);
        this.getChildren().add(scrollContainer);
    }

    /**
     * Runs the search event.
     *
     * @param event Key pressed event.
     */
    private void onSearch(KeyEvent event) {
        if (this.onSearch != null) {
            this.onSearch.accept(this.searchField.getText().replaceAll("  ", " ").split(" "));
        }
    }

    /**
     * Sets the search event.
     *
     * @param onSearch Search event.
     */
    public void setOnSearch(Consumer<String[]> onSearch) {
        this.onSearch = onSearch;
    }

    /**
     * Sets the list of contacts to show.
     *
     * @param contacts List of contacts.
     */
    public void setContacts(Collection<Contact> contacts) {
        HashMap<Character, ArrayList<Contact>> contactsCategorised = new HashMap<>();
        this.listViews = new ArrayList<>();
        this.contactNavigation.clear();
        this.contacts.clear();
        Contact[] contactsArray = new Contact[contacts.size()];
        contacts.toArray(contactsArray);
        Arrays.sort(contactsArray);
        for (Contact contact : contactsArray) {
            if (!contact.isValid()) {
                contact.delete();
            } else {
                if (contact.exists()) {
                    try {
                        char initialLetter = contact.getDisplayTitle().charAt(0);
                        if (!contactsCategorised.keySet().contains(initialLetter)) {
                            ArrayList<Contact> contactsByInitialLetter = new ArrayList<>();
                            contactsByInitialLetter.add(contact);
                            contactsCategorised.put(initialLetter, contactsByInitialLetter);
                        } else {
                            contactsCategorised.get(initialLetter).add(contact);
                        }
                        this.contacts.add(contact);
                    } catch (Exception ex) {
                        System.err.println("[ERROR]: Failed to add contact " + contact.getId() + " to contacts..");
                    }
                }
            }
        }
        List<Character> indexSorted = new ArrayList<>(contactsCategorised.keySet());
        Collections.sort(indexSorted, Character::compareTo);
        for (char index : indexSorted) {
            CategorisedListView listView = new CategorisedListView(
                    Character.toString(index),
                    contactsCategorised.get(index),
                    this::onTabSelected);
            this.listViews.add(listView);
            this.contactNavigation.addRow(listView);
        }
    }

    /**
     * Runs the tab selected event.
     *
     * @param navigationTab Selected tab.
     */
    public void onTabSelected(ContactNavigationTab navigationTab) {
        if (this.onTabSelectedEvent != null && navigationTab != null)
            this.onTabSelectedEvent.accept(navigationTab);
    }

    /**
     * Sets the selected contact.
     *
     * @param contact Contact to select.
     */
    public void setSelected(Contact contact) {
        for (CategorisedListView listView : this.listViews) {
            for (ContactNavigationTab navigationTab : listView.getNavigationTabs()) {
                if (contact.getId() == navigationTab.getContact().getId()) {
                    this.setSelected(navigationTab);
                }
            }
        }
    }

    /**
     * Checks if the navigation list contains a specific contact.
     *
     * @param contact Contact to look for.
     * @return Does the list contain specified contact.
     */
    public boolean hasContact(Contact contact) {
        return this.contacts.contains(contact);
    }

    /**
     * Sets the selected navigation tab.
     *
     * @param navigationTab Navigation tab to select.
     */
    public void setSelected(ContactNavigationTab navigationTab) {
        if (navigationTab.equals(this.selectedNavigationTab)) {
            return;
        }
        if (this.selectedNavigationTab != null) {
            this.selectedNavigationTab.toggleSelected();
        }
        this.selectedNavigationTab = navigationTab;
        this.selectedNavigationTab.toggleSelected();

    }

    /**
     * Sets the on tab select event.
     *
     * @param onTabSelectedEvent Selected event.
     */
    public void setOnTabSelectedEvent(Consumer<ContactNavigationTab> onTabSelectedEvent) {
        this.onTabSelectedEvent = onTabSelectedEvent;
    }
}
