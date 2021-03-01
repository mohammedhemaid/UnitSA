package com.app.unit.unitsa.ui.maintenancelist

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.app.unit.unitsa.api.model.responses.Maintenance
import com.app.unit.unitsa.api.repositories.MaintenanceRepository
import retrofit2.HttpException
import java.io.IOException

private const val PAGINATION_STARTING_PAGE = 0

class MaintenanceDataSource(
    private val maintenanceRepository: MaintenanceRepository,
    private val token: String,
) : PagingSource<Int, Maintenance>() {

    override fun getRefreshKey(state: PagingState<Int, Maintenance>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Maintenance> {
        val position = params.key ?: PAGINATION_STARTING_PAGE

        return try {
            val response =
                maintenanceRepository.getMaintenanceList(token, position, params.loadSize)
            val data = response.data?.data
            val pagination = response.data?.pagination
            val isLastPage = pagination?.currentPage == pagination?.total
            val maintenanceList = data?.maintenanceList ?: ArrayList()

            LoadResult.Page(
                data = maintenanceList,
                prevKey = if (position == PAGINATION_STARTING_PAGE) null else position - params.loadSize,
                nextKey = if (isLastPage) null else position + params.loadSize
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}