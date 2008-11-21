//
// $Id$
//
// Depot library - a Java relational persistence library
// Copyright (C) 2006-2008 Michael Bayne and Pär Winzell
// 
// This library is free software; you can redistribute it and/or modify it
// under the terms of the GNU Lesser General Public License as published
// by the Free Software Foundation; either version 2.1 of the License, or
// (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA

package com.samskivert.depot;

import java.sql.Connection;
import java.sql.SQLException;

import com.samskivert.jdbc.DatabaseLiaison;

/**
 * An abstraction that encompasses both {@link Query} and {@link Modifier} operations.
 */
public interface Operation<T>
{
    /**
     * Indicates whether or not this operation is safe to invoke on a database mirror.
     */
    public boolean isReadOnly ();

    /**
     * Performs the actual JDBC interactions associated with this operation.
     */
    public T invoke (PersistenceContext ctx, Connection conn, DatabaseLiaison liaison)
        throws SQLException;

    /**
     * Called after the operation has been invoked so that it can update our runtime statistics.
     */
    public void updateStats (Stats stats);
}
