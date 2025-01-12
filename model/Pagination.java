package com.example.airtravelwebapp.model;

/**
 * Represents pagination details in an API response.
 */
public class Pagination {
    private int currentPage; // The current page number
    private int totalPages; // The total number of pages
    private int itemsPerPage; // The number of items per page
    private int totalItems; // The total number of items

    // Getters and setters

    /**
     * Gets the current page number.
     * @return the current page number
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * Sets the current page number.
     * @param currentPage the current page number
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * Gets the total number of pages.
     * @return the total number of pages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * Sets the total number of pages.
     * @param totalPages the total number of pages
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * Gets the number of items per page.
     * @return the number of items per page
     */
    public int getItemsPerPage() {
        return itemsPerPage;
    }

    /**
     * Sets the number of items per page.
     * @param itemsPerPage the number of items per page
     */
    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * Gets the total number of items.
     * @return the total number of items
     */
    public int getTotalItems() {
        return totalItems;
    }

    /**
     * Sets the total number of items.
     * @param totalItems the total number of items
     */
    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
}